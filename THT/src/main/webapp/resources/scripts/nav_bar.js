     function setSearchBoxWidth()
            {
                 var max_width = document.documentElement.clientWidth-560;
                 var primary = document.getElementById('search_box');
                 primary.style.width = max_width+"px";
                 primary.style.minWidth = max_width+"px";
                 primary.style.maxWidth = max_width+"px"; 
 
           }