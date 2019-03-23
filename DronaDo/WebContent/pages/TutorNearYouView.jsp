<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<script type="text/javascript">
var map = null;
var entryInformation =[];
var Location =[];
function loadmap(entry_information,latitude,longitude){
	if(latitude!=null && longitude!= null){
		 //alert(typeof(latitude)+latitude+typeof(longitude)+longitude);
   map = new google.maps.Map(document.getElementById('map'), {
     center: {lat: latitude , lng:longitude },
     zoom: 16,
   });
   var marker = new google.maps.Marker(
	{position:{lat: latitude , lng:longitude},
	   icon: "https://www.google.com/mapfiles/arrow.png",
	   title:entry_information,
	   map:map
	});
	}else{
	 	alert("There is some problem in address so please contact development team");
	 } 	
}
function getMarker(entry_information,latitude,longitude){
	//alert("inside marker ");
	if(latitude!=null && longitude!= null && map!=null){
		var marker = new google.maps.Marker(
				{position:{lat: latitude , lng:longitude},
					   icon:"https://maps.google.com/mapfiles/kml/shapes/man.png",
					   title:entry_information,
					   map:map
					});
	}
}
function loadMapWithMarker(){
	loadmap(entryInformation[0],Location[0][0],Location[0][1]);
	for(var i =1;i<entryInformation.length;i++){
		getMarker(entryInformation[i],Location[i][0],Location[i][1]);
	}
	
}
</script>
</head>
<body>
<div class ="container">
<h1 class="font-italic  ml-3">Tutor Near You</h1>
<div class="container" id="map" style="width:100%;" ></div>

<%
String [] entry_information = (String [])request.getAttribute("entry_information");
float [] [] location =(float[][])request.getAttribute("location");
%>

<script type="text/javascript">
<% for(int i=0;i<entry_information.length;i++){ %>
entryInformation.push("<%=entry_information[i]%>");
Location.push([<%=location[i][0]%>,<%=location[i][1]%>]);
<%}%>
</script>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDyGiXClmvyhTyROW-N9yKodcoxUk_3bgI&libraries=places"
    async defer onload="loadMapWithMarker();"></script>
</div>
</body>
</html>