// const fs = require('fs');

// let data = "namasta ji ki haal chaal copy to all";
// fs.writeFile('sam.txt', data, {},()=>{});


// fs.readFile('sam.txt', 'utf8', (err, data) => {
//     if (err) {
//         throw err; // Handle the error appropriately
//     }
//     console.log("File contents:", data);
// });


// fs.appendFile('sam.txt', ' namaste ji', (err) => {
//     if (err) {
//         console.error("Error appending to file:", err);
//         return;
//     }
//     console.log("Data appended successfully");
// });

// fs.unlink('sam.txt', (err) => {
//     if (err) {
//         console.error("Error deleting file:", err);
//         return;
//     }
//     console.log("File deleted successfully");
// });



const sam ="web";

function jain() {
    console.log("Hello, world!");
}

let mav={
    a: "woof woof"
}

module.exports = {sam, jain, mav};