const express=require("express");
let app=express();

app.get('/',(req,res)=>{
    res.send("chalu hogya")
});
app.get("/home",(req,res)=>{
    res.send("chabi bhul gaya")
})
app.listen(8080,()=>{
    console.log("browser khol le")
})