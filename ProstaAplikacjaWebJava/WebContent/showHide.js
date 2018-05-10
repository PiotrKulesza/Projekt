/**
 * 
 */

function toggole(id){
	var element = getElementsByClassName(id);
	
	if(element.style.display == "none")
		show(id);
	else
		hide(id);
}

function show(id){
	
	document.getElementsByClassName(id).style.display = "block";
	
}

function hide(id){
	document.getElementsByClassName(id).style.display = "none";
}