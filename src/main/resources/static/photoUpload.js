window.numberOfFiles = 0;
window.processedFiles = 0;

function myFunction(){
	var files = document.getElementById("fileUpl").files;
	hash = makeHash(10);
	window.numberOfFiles = files.length;
    $('input[id="hash"]').val(hash);
	$('input[type="submit"]').prop('disabled', true);
	console.log('Załadowano ' + files.length + 'plików. Mam hash ' + hash);
	for (var i = 0; i<files.length; i++) {
		if (files[i].type.match('image.*')) {
			resize(files[i], hash);
		}
	}
};

function resize(file, hash) {
	var rdr = new FileReader();
	var img = new Image();
	rdr.readAsDataURL(file);
	rdr.onload = function(event) {
		img.src = event.target.result;
		console.log('Img.src = ' + img.src);
		console.log('File.name = ' + file.name);
		img.onload = function() {
			var canvas = document.createElement('canvas');
			console.log('image loaded!' + img);
			//var ctx = canvas.getContext("2ds");
			//ctx.drawImage(img, 0, 0);
			var MAX_WIDTH = 1200;
			var MAX_HEIGHT = 900;
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

			    var dataToSend = JSON.stringify({dataUrl: dataurl, nazwaPliku: file.name, hash: hash});
			    console.log('dataToSend: '+dataToSend);
			    $.ajax(
                {
                url: "photoUploadJson",
                type: "POST",
                contentType: "application/json",
                data: dataToSend,
                success: function(data, textStatus, jqXHR)
                    {
                    window.processedFiles++;
                    console.log("Przetworzylem " + window.processedFiles + " z " + window.numberOfFiles + " plików.");
                    if (window.processedFiles == window.numberOfFiles) {
                        console.log("PRZETWORZYEM WSZYSTKIE PLIKI!");
                        $('input[type="submit"]').prop('disabled', false);
                        }
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

function makeHash(howManyChars) {
    var text = "";
    var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    for( var i=0; i < howManyChars; i++ )
    {
        text += possible.charAt(Math.floor(Math.random() * possible.length));
    }
        return text;
};
