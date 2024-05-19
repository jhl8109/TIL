<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Example</title>
    <style type="text/css">
        #linkContainer {
            display: flex;
            flex-wrap: wrap;
            width: 310px;
        }
    
        #linkContainer a  {
            display: block;
            list-style-type: none;
            text-align: center;
            font-size: 3em;
            border: 1px solid;
            width: 150px;
            float: left;
            margin: 1px;
        }        
        a   { 
            text-decoration: none;
        }
        .pagination {
            visibility: hidden;
            display: inline-block;
        }
        .pagination div {
            float: left;
            padding: 8px 16px;
        }
        .pagination div.active {
            background-color: #4CAF50;
            color: white;
        }
        .pagination div:hover:not(.active) {background-color: #ddd;}
        .maindiv {
            width: 320px;
            float: left;
        }
        iframe {
            width: 500px;
            height: 500px;
            float: left;
        }
    </style>
    <?php
        $title = '';
        $src = '';
        function setData() {
            $conn= mysqli_connect("127.0.0.1","root","810900","201824557",3307);
            $res = mysqli_query($conn, "select * from web_hw");
            $result = array();
            
            while($row = mysqli_fetch_array($res)) {
                array_push($result,
                array('title'=>$row[1],'src'=>$row[2]));
            }         
            $json = json_encode($result);
            mysqli_free_result($res);
            mysqli_close($conn);
            echo $json;
        }

        function updateData() {
            if (isset($_GET['linkTitle'])  && isset($_GET['linkSrc']) && isset($_GET['addBtn'])) {
                $title = $_GET['linkTitle'];
                $src = $_GET['linkSrc'];
                if ($title != '' && $src != '') {
                    $conn=mysqli_connect("127.0.0.1","root","810900","201824557",3307);
                    $sql =  "INSERT INTO web_hw (id,link_title,link_src) VALUES (NULL,'$title','$src');";
                    mysqli_query($conn, $sql);                   
                    $title = '';
                    $src = '';
                    mysqli_close($conn);
                }
            }
        }
        function deleteData() {
            if (isset($_GET['linkTitle']) && isset($_GET['delBtn'])) {
                $title = $_GET['linkTitle'];
                $conn=mysqli_connect("127.0.0.1","root","810900","201824557",3307);
                $sql =  "DELETE FROM web_hw WHERE link_title = '$title';";
                mysqli_query($conn, $sql);
                mysqli_close($conn);
                $title = '';
            }
            
        }
        function clearAll() {
            if (isset($_GET['clearBtn'])) {
                $conn=mysqli_connect("127.0.0.1","root","810900","201824557",3307);
                $sql =  "TRUNCATE TABLE web_hw;";
                mysqli_query($conn, $sql);
                mysqli_close($conn);
            }
            
        }
    ?>
    <script type="text/javascript">
        var links = '';
        var linkArr = new Array();
        var curPage = 0;

        function addLink()
        {
            if (linkArr.findIndex(checkTitle) >= 0)
            {
                window.alert("이미 있는 즐겨찾기 제목입니다. 다른 제목을 사용해주세요.");
                return;
            }
            linkArr.push({title: document.forms[0].linkTitle.value, src: document.forms[0].linkSrc.value});
            linkArr.sort(compareTitle);
            updateData();
        }
        function checkTitle(link)
        {
            return link.title == document.forms[0].linkTitle.value;
        }
        function compareTitle(link1, link2)
        {
            if (link1.title > link2.title)
                return 1;
            else if (link1.title < link2.title)
                return -1;
            else
                return 0;
        }       
        function deleteLink()
        {
            var idx = linkArr.findIndex(checkTitle);
            if (idx < 0)
            {
                window.alert("일치하는 제목을 가진 즐겨찾기가 없습니다.");
                return;
            }
            linkArr.splice(idx, 1);
            makePages();
            showLinks();
            <?= deleteData();?>
        }
        function clearAll()
        {
            linkArr = Array();
            document.getElementById("linkContainer").innerHTML = "";
            <?= clearAll(); ?>
        }
        function showLinks()
        {
            var linkContainer = document.getElementById("linkContainer");
            linkContainer.innerHTML = "";

            var startIdx = curPage * 10;
            var endIdx = startIdx + 9;
            for(var idx = startIdx; idx <= endIdx && idx < linkArr.length; idx++)
            {
                var link = makeLink(linkArr[idx].title, linkArr[idx].src);
                linkContainer.innerHTML += link;
            }
        }
        function makeLink(title, src)
        {
            return "<a href='" + src + "' target=\"linkFrame\">" + title + "</a>";
        }
        function makePages()
        {
            if (linkArr.length > 10)
            {
                var pageNav = document.getElementById("pageNav");
                pageNav.style.visibility = "visible";
                pageNav.innerHTML = "";
                var nPage = Math.ceil(linkArr.length / 10);
                for(var i =0; i < nPage; i++)
                {
                    if (i == curPage)
                        pageNav.innerHTML += "<div class=\"active\" onclick=\"changePage(" + i +")\">" + (i + 1) + "</div>";
                    else
                        pageNav.innerHTML += "<div onclick=\"changePage(" + i +")\">" + (i + 1) + "</div>";

                }
            }
        }
        function changePage(pageNum)
        {
            curPage = pageNum;
            makePages();
            showLinks();
        }
        function updateData()
        {
            <?= updateData();?>;
            links = '<?=setData();?>';
            if (links != null)
            {
                linkArr = JSON.parse(links);
                makePages();
                showLinks();
            }
        }
        function start()
        {
            links = '<?=setData();?>';
            if (links != null)
            {
                linkArr = JSON.parse(links);
                makePages();
                showLinks();
            }
        }
    </script>
    </head>
<body onload=start()>
    <div class="maindiv">
        <form name="form1" method="GET" action="#">
            <label>즐겨찾기 제목: <input type="text" name="linkTitle" id="linkTitle"></label><br>
            <label>즐겨찾기 링크: <input type="text" name="linkSrc" id="linkSrc"></label><br>
            <input type="submit" name="addBtn" id="addBtn" value="즐겨찾기 추가" onclick=addLink()>
            <input type="submit" name="delBtn" id="delBtn" value="즐겨찾기 삭제" onclick=deleteLink()>
            <input type="submit" name="clearBtn" id="clearBtn" value="모두 삭제" onclick=clearAll()>
        </form>
        <br>
        <div id="linkContainer">
        </div>
        <nav class="pagination" id="pageNav">
        </nav>
    </div>
    <iframe title="iframe for link" name="linkFrame"></iframe>
</body>
</html>
