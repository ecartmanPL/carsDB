function myFunction(){
	var files = document.getElementById("fileUpl").files;
	console.log('Załadowano ' + files.length + 'plików.');
	for (var i = 0; i<files.length; i++) {
		if (files[i].type.match('image.*')) {
			resize(files[i]);
		}
	}
};

function resize(file) {
	console.log("w funkcji A" + file);
	var rdr = new FileReader();
	var img = new Image();
	rdr.readAsDataURL(file);
	rdr.onload = function(event) {
		img.src = event.target.result;
		console.log('Img.src = ' + img.src);
		img.onload = function() {
			var canvas = document.createElement('canvas');
			console.log('image loaded!' + img);
			//var ctx = canvas.getContext("2d");
			//ctx.drawImage(img, 0, 0);
			var MAX_WIDTH = 800;
			var MAX_HEIGHT = 600;
			var width = img.width;
			var height = img.height;
			if (width > height) {
			  if (width > MAX_WIDTH) {
			    height *= MAX_WIDTH / width;
			    width = MAX_WIDTH;
			  }
			} else {
			  if (height > MAX_HEIGHT) {
			    width *= MAX_HEIGHT / height;
			    height = MAX_HEIGHT;
			  }
			}
			canvas.width = width;
			canvas.height = height;
			var ctx = canvas.getContext("2d");
			ctx.drawImage(img, 0, 0, width, height);
			var dataurl = canvas.toDataURL("image/jpeg", 0.5);
			console.log('DataURL = ' + dataurl);
			var tImg = document.createElement("img");
			tImg.setAttribute("src", dataurl);
			tImg.setAttribute("width", canvas.width);
			tImg.setAttribute("height", canvas.height);

			    var dataToSend = JSON.stringify({id : 123, sciezka: dataurl});
			    console.log('dataToSend: '+dataToSend);
			    $.ajax(
                {
                url: "photoUploadJson",
                type: "POST",
                contentType: "application/json",
                data: dataToSend,
                success: function(data, textStatus, jqXHR)
                    {
                    //alert("success");
                    },
                error: function(jqXHR, textStatus, errorThrown)
                    {
                    //alert("error");
                    }
                });
			console.log(tImg);
			document.body.appendChild(tImg);
		}
	};
};
