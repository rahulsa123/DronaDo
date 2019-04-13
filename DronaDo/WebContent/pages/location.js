 // for edit profile default map
  var map;
  var latitude = Number(document.getElementById("latitude").value);
  var longitude = Number(document.getElementById("longitude").value);
  function initMap() {
	  
 	 if(latitude!=null && longitude!= null){
 		 //alert(typeof(latitude)+latitude+typeof(longitude)+longitude);
    map = new google.maps.Map(document.getElementById('map'), {
      center: {lat: latitude , lng:longitude },
      zoom: 16
    });
    var marker = new google.maps.Marker({position:{lat: latitude , lng:longitude}, map:map,title:"Your Location"});
 }else{
 	alert("There is some problem in address so please contact development team");
 } 	
}

  
// for new map 
  function getLocation() {
	 
	  if (navigator.geolocation) {
          navigator.geolocation.getCurrentPosition(function(position) {
        	  document.getElementById("new_latitude").value = position.coords.latitude;
        	  document.getElementById("new_longitude").value = position.coords.longitude;
        	  alert("current location found");
        	  alert(document.getElementById("new_latitude").value);
        	  alert(document.getElementById("new_longitude").value);
          }, function() {
            handleLocationError(true, infoWindow, map.getCenter());
          });
     }else{
    	 alert("Error: Your browser doesn\'t support geolocation.");
     }
}