import { useState, memo, useMemo } from "react";

function UseMomoo() {
    const [inp, setInp] = useState(0);
    const [count, setCount] = useState(0);
    let out = useMemo(() => {
        let ans = 0;
        for(let item=1;item<=inp;item++){
            console.log("loop chala");
            ans+=item;
        }
        return ans;
    }, [inp]);

    function handleInp(e) {
        setInp(e.target.value);
    }

    return (
        <div>
            <input type="text" onChange={handleInp} value={inp} />
            <h1>Output is {out}</h1>
            <button onClick={() => setCount(count + 1)}>Count {count}</button>
        </div>
    )
}

export default UseMomoo;