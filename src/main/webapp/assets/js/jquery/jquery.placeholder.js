/*!
 * copyright c by zhangxinxu 2012-02-06
 * jquery.placeholder.js placeholder属性模拟插件
 * v1.0 2012-02-06 create
 * v1.2 2012-12-20 兼容IE10下IE6-IE7，同时jQuery1.4.*版本
 * v1.3 2013-06-14 label元素margin/padding无效问题
 * v1.3.1 2013-08-08 修复一个分号书写错误
 * @see http://www.zhangxinxu.com/wordpress/2012/02/html5-placeholder%E4%BD%BF%E7%94%A8%E7%BB%8F%E9%AA%8C%E5%88%86%E4%BA%AB%E5%8F%8A%E6%8B%93%E5%B1%95/
 */

(function ($, undefined) {
    "use strict";

    $.fn.placeholder = function (options) {
        var defaults = {
            labelMode: false,
            labelStyle: {},
            labelAlpha: false,
            labelAcross: false
        };
        var params = $.extend({}, defaults, options || {}); // 扩展配置到一个新对象

        // 方法
        var funLabelAlpha = function (elementEditable, elementCreateLabel) {
            // 如果输入框为空,设置placeholder透明度，不为空，设置placeholder为空
            if (elementEditable.val() === "") {
                elementCreateLabel.css("opacity", 0.4).html(elementEditable.data("placeholder"));
            } else {
                elementCreateLabel.html("");
            }
        }, funPlaceholder = function (ele) {
            // 为了向下兼容jQuery 1.4
            if (document.querySelector) {
                return $(ele).attr("placeholder");
            } else {
                // IE6, 7
                var ret;
                ret = ele.getAttributeNode("placeholder");
                // Return undefined if nodeValue is empty string
                return ret && ret.nodeValue !== "" ? ret.nodeValue : undefined;
            }
        };

        $(this).each(function () {  // 对选中的每个元素执行下面的代码
            var element = $(this),  // 保存成局部变量
                isPlaceholder = "placeholder" in document.createElement("input"),
                placeholder = funPlaceholder(this); // 取得placeholder的值

            // 三种情况打酱油
            // ① 没有placeholder属性值
            // ② value模拟，同时是支持 placeholder 属性的浏览器
            // ③ label模拟，但是无需跨浏览器兼容，同时是支持placeholder属性的浏览器
            if (!placeholder || (!params.labelMode && isPlaceholder) ||
                    (params.labelMode && !params.labelAcross && isPlaceholder)) {
                return;
            }

            // 存储，因为有时会清除placeholder属性
            element.data("placeholder", placeholder);   // 将placeholder存储到data属性里

            // label模拟
            if (params.labelMode) { // 如果labelMod模拟为真
                var idElement = element.attr("id"),
                    elementLabel = null;
                if (!idElement) {   // 如果id不存在
                    idElement = "placeholder" + Math.random();  // 生成随机id
                    element.attr("id", idElement);
                }

                // 状态初始化
                elementLabel = $('<label for="' + idElement + '"></label>').css($.extend({
                    lineHeight: "1.3",
                    position: "absolute",
                    color: "graytext",
                    cursor: "text",
                    marginLeft: element.css("marginLeft"),
                    marginTop: element.css("marginTop"),
                    paddingLeft: element.css("paddingLeft"),
                    paddingTop: element.css("paddingTop")
                }, params.labelStyle)).insertBefore(element);   // 在前面插入label，样式可以自定

                // 事件绑定
                if (params.labelAlpha) {    // 如果定义了透明度
                    // 如果是为空focus透明度改变交互
                    element.bind({
                        "focus": function () {  // 获得焦点的时候
                            funLabelAlpha($(this), elementLabel);
                        },
                        "input": function () {  // 输入的时候
                            funLabelAlpha($(this), elementLabel);
                        },
                        "blur": function () {   // 失去焦点的时候
                            if (this.value === "") {
                                elementLabel.css("opacity", 1).html(placeholder);
                            }
                        }
                    });

                    // IE6~8不支持oninput事件，需要另行绑定
                    if (!window.screenX) {  // 特征检测，IE6~8不支持这个属性
                        element.get(0).onpropertychange = function (event) {
                            event = event || window.event;
                            if (event.propertyName === "value") {   // 值改变的时候触发
                                funLabelAlpha(element, elementLabel);
                            }
                        };
                    }

                    // 阻止对label的鼠标右键事件
                    elementLabel.get(0).oncontextmenu = function () {
                        element.trigger("focus");
                        return false;
                    };
                } else {
                    // 未定义透明度的时候，如果是单纯的value交互
                    element.bind({
                        "focus": function () {
                            elementLabel.html("");
                        },
                        "blur": function () {
                            if ($(this).val() === "") {
                                elementLabel.html(placeholder);
                            }
                        }
                    });
                }

                // 内容初始化
                if (params.labelAcross) {
                    element.removeAttr("placeholder");
                }

                if (element.val() === "") {
                    elementLabel.html(placeholder);
                }
            } else {
                // value模拟
                element.bind({
                    "focus": function () {
                        if ($(this).val() === placeholder) {
                            $(this).val("");
                        }
                        $(this).css("color", "");
                    },
                    "blur": function () {
                        if ($(this).val() === "") {
                            $(this).val(placeholder).css("color", "graytext");
                        }
                    }
                });

                // 初始化
                if (element.val() === "") {
                    element.val(placeholder).css("color", "graytext");
                }
            }
        });
        return $(this);
    };
})(jQuery);
