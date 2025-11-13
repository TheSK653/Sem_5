let n  = process.argv.pop();
let a = 3, b = 5;
for(let i=1; i<=n; i++) {
    if(i%3===0 & i%5===0) {
        console.log(i, "fizz-buzz");
    }
    else if(i%3===0 ) {
        console.log(i, "fizz");
    } 
    else if (i%5===0) {
        console.log(i, "buzz");
    }
    else {
        console.log(i);
    }
}


// console.log(n);



// const readline = require('readline');

// const rl = readline.createInterface({
//     input: process.stdin,
//     output: process.stdout
// });

// rl.question("Enter a number: ", function(input) {
//     let n = parseInt(input);
//     let c3 = 1;
//     let c5 = 1;

//     for (let i = 1; i <= n; i++) {
//         let str = "";

//         if (c3 === 3) {
//             str += "fizz";
//             c3 = 0;
//         }

//         if (c5 === 5) {
//             str += "buzz";
//             c5 = 0;
//         }

//         if (str === "") {
//             str += i;
//         }

//         c3++;
//         c5++;

//         console.log(str);
//     }

//     rl.close();  // Close input after done
// });