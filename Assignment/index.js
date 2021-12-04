const express = require('express');
const app = express();
const port = 3000;
const mysql = require('mysql');

app.use('/public',express.static('public'));
app.use(express.json());

app.get('/',(req,res) => {
    const conn = mysql.createConnection({
        host : 'localhost',
        port : 3307,
        user : 'root',
        password : '810900',
        database : '201824557'
    });
    conn.connect();
    var sql = 'SELECT * FROM web_hw';
    conn.query(sql,function(err,results){
        if(err){
            console.log(err);
            res.send("failed");
        }else{
            console.log(results);
            res.json(results);
        }
    })
    conn.end();
})
app.post('/add', (req,res) => {
    console.log("add")
    const conn = mysql.createConnection({
        host : 'localhost',
        port : 3307,
        user : 'root',
        password : '810900',
        database : '201824557'
    });
    conn.connect();
    var title = req.body.title;
    var src = req.body.src;
    var sql = 'INSERT INTO `web_hw`(`link_title`, `link_src`) VALUES (?,?)';
    var params = [title,src];
    conn.query(sql,params,function(err,results){
        if(err){
            console.log(err);
            res.send("failed");
        }else{
            console.log(results);
            res.send("success");
        }
    })
    conn.end();
});

app.post('/delete', (req,res) => {
    const conn = mysql.createConnection({
        host : 'localhost',
        port : 3307,
        user : 'root',
        password : '810900',
        database : '201824557'
    });
    conn.connect();
    var title = req.body.title;
    console.log(title);
    var sql = 'DELETE FROM `web_hw` WHERE link_title = ?';
    conn.query(sql,title,function(err,results){
        if(err){
            console.log(err);
            res.send("failed");
        }else{
            console.log(results);
            res.send("success");
        }
    })
    conn.end();
});

app.get('/all', (req,res) => {
    const conn = mysql.createConnection({
        host : 'localhost',
        port : 3307,
        user : 'root',
        password : '810900',
        database : '201824557'
    });
    conn.connect();
    var sql = 'TRUNCATE web_hw';
    conn.query(sql,function(err,row,field){
        if(err){
            console.log(err);
            res.send("failed");
        }else{
            res.send("success");
        }
    })
    conn.end();
});

app.listen(port,()=>console.log(`example app listening http://localhost:${port}`));