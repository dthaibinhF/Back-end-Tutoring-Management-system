import {RouterProvider, Switch, Route  } from "react-router-dom";
import {Login, HomeLayout, Landing, Dashboard} from "./app/pages/index.js";
import router from "./app/router/route.js";
import {useState} from "react";

function App() {
    const [isAuthentication, setIsAuthentication] = useState(false);
    if (isAuthentication) {
        return (
            <RouterProvider router={router}/>
        )
    }
    return (
        <Switch/>
    )
}

export default App
