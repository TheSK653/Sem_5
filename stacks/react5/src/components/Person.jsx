import {useState,memo} from "react";

function Person() {
    let [dog,setDog] = useState('Maverick');
    
    function handleName(){
        setDog(Math.floor(Math.random()*10));
    }
    
    let [inp,setInp] = useState('');
    function handleInp(e){
        setInp(e.target.value);
    }

    return (
        <div>
            <input type="text" onChange={handleInp} value={inp}/>
            <Chotu name={inp}/>
            <button onClick={handleName}>Change Name</button>
            <Chotu name={dog}/>
            <Chotu name="Simba"/>
            <Chotu name="Dodo"/>
            <Chotu name="Nepali"/>
        </div>
    )
}
const Chotu = memo(function({name}){
    return (
        <h1>Chai leke aya malik {name}</h1>
    )
})

export default Person;
