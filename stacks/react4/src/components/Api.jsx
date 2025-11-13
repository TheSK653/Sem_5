// import { useState, useEffect } from "react";
// import axios from "axios";


// function Api() {
//   const API = "https://jsonplaceholder.typicode.com/todos/1";
//   const [data, setData] = useState(null);

// //   useEffect(() => {
// //     fetch(API)
// //       .then((res) => res.json())
// //       .then((res) => {
// //         setData(res);
// //       })
// //       .catch((error) => {
// //         console.log(error);
// //       });
// //   }, []);

// useEffect(()=>{
//     axios.get(API)
//     .then((response)=>{
//         console.log(response,"then");
//     }).catch((error)=>{
//         console.log(error);
//     })
// })

//   return (
//     <div>
//       {data && (
//         <h3>Title : {data.title}</h3>
//       )}
//     </div>
//   );
// }

// export default Api;

// //////////////////////////////////////////////////////////////////////////////////////

// Using async await

import { useState, useEffect } from "react";
import axios from "axios";


function Api() {
  const API = "https://jsonplaceholder.typicode.com/todos/1";
  const [data, setData] = useState(null);

//   useEffect(() => {
//     fetch(API)
//       .then((res) => res.json())
//       .then((res) => {
//         setData(res);
//       })
//       .catch((error) => {
//         console.log(error);
//       });
//   }, []);

useEffect(()=>{
   async function apiCalling() {
      try {
        const res = await axios.get(API);
        setData(res.data);
      } catch (error) {
        console.log(error);
      }
    }
    // apiCalling();
})

  return (
    <div>
      {data && (
        <h3>Title : {data.title}</h3>
      )}
    </div>
  );
}

export default Api;