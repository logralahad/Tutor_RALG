window.onload = function myFunction() {
	var url = window.location.href.toLowerCase().split("/");
	var page = url[url.length - 1];
	var elms = Array.from(document.querySelectorAll('#menuLateral>ul>li>a'));
	elms.forEach(element => {
		let sectionIn = element.textContent.trim().toLowerCase();
		if(page.includes(sectionIn) || (sectionIn === "dashboard" && page.includes("perfil"))){
			element.className = "nav-link active"
		}
		else{
			element.className = "nav-link"
		}
	})
}

