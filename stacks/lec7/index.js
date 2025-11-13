const express=require('express');
const app=express();
const mongoose=require('mongoose');
mongoose.connect('mongodb+srv://sohamkundu653:wmC3TpENpFUc8yha@cluster0.1kh6mf3.mongodb.net/')
.then(() => {
    console.log("db connected");
})
.catch((err) => {
    console.log("db not connected", err);
}); 

app.get('/', (req, res) => {
    res.send("hello world");
});

const PORT = 8080;
app.listen(PORT, () => {
    console.log(`server is running on port ${PORT}`);
});