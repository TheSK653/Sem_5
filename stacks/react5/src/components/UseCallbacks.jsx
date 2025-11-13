import React,{useState,memo} from "react";
function UseCallbacks() {
    const [count,setCount] = useState(0);
    let a=0;
    
    return (
        <div>
            <Chotu name={a}/>
            <button onClick={()=>setCount(count+1)}>Count {count}</button>
        </div>
    )
}
const Chotu = memo(function({name}){
    return (
        <h1>Chai leke aya malik {name}</h1>
    )
})

export default UseCallbacks;