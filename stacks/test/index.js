const { log } = require('console');
const express = require('express');
const app = express();
const path = require('path');
const methodOverride = require('method-override')
const { v4: uuidv4 }  =  require('uuid');


let blogs=[
    {
        id:uuidv4(),
        name:"1st",
        content:"for demo",
        author:"TheSK",
        time:"HH:MM:SS"
    }

];

let users=[
    {
        name:"TheSK",
        email:"sohamkundu653@gmail.com",
        add:{
            location:"1-block"
        }
    }
];

app.set("view engine","ejs");
app.set("views",path.join(__dirname,"views"));

app.use(express.static(path.join(__dirname, 'public')))

app.use(express.urlencoded({ extended: true }))
app.use(methodOverride('_method')) //middleware of patch/put/delete



app.get('/',(req,res)=>{
    res.send("this is the index")
});



//blogs list
app.get('/blogs',(req,res)=>{
    res.render('blog/index',{blogs})
});



//new blog creation
app.get('/blogs/new' , (req,res)=>{
    res.render('blog/new')
})
app.post('/blogs' , (req,res)=>{
    let {name,content,author} = req.body;
    blogs.push({id:uuidv4(), name, content, author})
    res.redirect('/blogs')
})

// particular blog
// app.get('/blogs/:idd' , (req,res)=>{
//     let {idd} = req.params;
//     let foundBlog = blogs.find((blog)=> blog.id == idd )
//     res.render('blogs/show', {foundBlog})
// })




// update
app.get('/blogs/:idd/edit' , (req,res)=>{
    let {idd} = req.params;
    let foundBlog = blogs.find((blog)=> blog.id == idd )
    res.render('blogs/edit' ,{foundBlog})
})

app.patch('/blogs/:iddd' , (req,res)=>{
    let {iddd} = req.params;
    let foundBlog = blogs.find((blog)=> blog.id == iddd )
    let {name,content,author} = req.body;
    foundBlog.name = name;
    foundBlog.content = content;
    foundBlog.author = author;
    res.redirect('/blogs')
})






app.get('/register',(req,res)=>{
    res.render('blog/register')
});

app.get('/login',(req,res)=>{
    res.render('blog/login',{users})
});




let port=8080;
app.listen(port,()=>{
    console.log(`Connested to ${port}`);
})