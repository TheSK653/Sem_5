import { useState,useEffect } from "react";

function Live() {
  const [count, setCount] = useState(0);
  useEffect(() => {
    if(count===0){
        console.log("Mounted");
    }
    if(count>0 &&count<0){
        console.log("Updated");
    }
    if(count===5){
        return console.log("Unmount");
    }
  }, [count]);

  return (
    <button onClick={() => setCount(count + 1)}>
      Click me {count} times
    </button>
  );
}

export default Live;
