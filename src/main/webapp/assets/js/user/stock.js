function addStock(){
	var stock = $("#stock");
	if(stock.val()!=""){
		var stockCode = stock.val();
		$.post("../user/addStock/"+stockCode,function() {
			
	    })
	    .success(function() {  })
	    .error(function() {   })
	    .complete(function() { window.location.reload();  });
		
	}
}

function delStock(code){
		$.post("../user/delStock/"+code,function() {
	    })
	    .success(function() {   })
	    .error(function() {   })
	    .complete(function() { window.location.reload(); });
}


setInterval("window.location.reload()",300000);