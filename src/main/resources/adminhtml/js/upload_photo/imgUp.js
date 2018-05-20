$(function(){
	var delParent;
	var defaults = {
		fileType         : ["jpg","png","bmp","jpeg"],   // 上传文件的类型
		fileSize         : 1024 * 1024 * 10                  // 上传文件的大小 10M
	};

	/*点击图片的文本框*/
	$(".file").change(function(){
		var idFile = $(this).attr("id");
		var file = document.getElementById(idFile);
		var imgContainer = $(this).parents(".z_photo"); //存放图片的父亲元素
		var fileList = file.files; //获取的图片文件
		var input = $(this).parent();//文本框的父亲元素
		var imgArr = [];
		//遍历得到的图片文件
		var numUp = imgContainer.find(".up-section").length;
		var totalNum = numUp + fileList.length;  //总的数量
		if(fileList.length > 5 || totalNum > 5 ){
			alert("上传图片数目不可以超过5个，请重新选择");  //一次选择上传超过5个 或者是已经上传和这次上传的到的总数也不可以超过5个
		}
		else if(numUp < 5){
			fileList = validateUp(fileList);
			for(var i = 0;i< fileList.length;i++){
              //  alert(fileList[i].name);
                var formData = new FormData($( "#uploadPhotoForm" )[0]);
                $.ajax({
                    url: "/admin/storemanage/uploadPic",
                    type: "POST",
                    data: formData,
                    dataType: 'json',
                    async: false,
                    cache: false,
                    contentType: false,
                    processData: false,
                    success:function (data) {
                        var code = data.code;
                        var msg = data.msg;
                        var imgServerUrl = data.fileName;
                        if (code==1) {

                            var imgUrl = window.URL.createObjectURL(fileList[i]);
                            imgArr.push(imgUrl);
                            var $section = $("<section class='up-section fl imgSection loading'>");
                            imgContainer.prepend($section);
                            var $span = $("<span class='up-span'>");
                            $span.appendTo($section);
                            var $img0 = $("<img class='close-upimg'>").on("click",function(event){
                                event.preventDefault();
                                event.stopPropagation();
                                $(".works-mask").show();
                                delParent = $(this).parent();
                            });
                            $img0.attr("src","/images/icon_delete_photo.png").appendTo($section);
                            var $img = $("<img class='up-img up-opcity'>");
                            $img.attr("src",imgArr[i]);
                            $img.appendTo($section);
                            var $p = $("<p class='img-name-p'>");
                            $p.html(fileList[i].name).appendTo($section);
                            var $input = $("<input id='taglocation' name='taglocation' value='' type='hidden'>");
                            $input.appendTo($section);
                            var $input2 = $("<input id='tags' name='tags' value='" + imgServerUrl + "  ' type='hidden'/>");
                            $input2.appendTo($section);
                        }
                        else if(code==2) {
                            alert(msg);
                        }
                    }
                });
		    }
		}
		setTimeout(function(){
             $(".up-section").removeClass("loading");
		 	 $(".up-img").removeClass("up-opcity");
		 },450);
		 numUp = imgContainer.find(".up-section").length;
		if(numUp >= 5){
			$(this).parent().hide();
		}
	});

    $(".z_photo").delegate(".close-upimg","click",function(){
     	  $(".works-mask").show();
     	  delParent = $(this).parent();
	});
		
	$(".wsdel-ok").click(function(){
		$(".works-mask").hide();
		var numUp = delParent.siblings().length;
		if(numUp < 6){
			delParent.parent().find(".z_file").show();
		}
		 delParent.remove();
	});
	
	$(".wsdel-no").click(function(){
		$(".works-mask").hide();
	});
		
	function validateUp(files){
			var arrFiles = [];//替换的文件数组
			for(var i = 0, file; file = files[i]; i++){
				//获取文件上传的后缀名
				var newStr = file.name.split("").reverse().join("");
				if(newStr.split(".")[0] != null){
						var type = newStr.split(".")[0].split("").reverse().join("");
						if(jQuery.inArray(type, defaults.fileType) > -1){
							// 类型符合，可以上传
							if (file.size >= defaults.fileSize) {
								alert(file.size);
								alert( '文件太大');
							} else {
								// 在这里需要判断当前所有文件中
								arrFiles.push(file);	
							}
						}else{
							alert('上传类型不符合');
						}
					}else{
						alert('无法识别');
					}
			}
			return arrFiles;
		}

})
