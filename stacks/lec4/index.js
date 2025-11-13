const express = require("express");
let app = express();

const path = require("path");

app.set("view engine", "ejs");
app.set("views",path.join(__dirname,'views'))

let arr = [1,2,3,4,5];

app.get("/", (req,res)=>{
    res.send("hello swagat h.....")
});

app.get("/home",(req,res)=>{
    res.render("display/index",{arr:arr})
});

app.listen(8080, ()=>{
    console.log("Successful")
});