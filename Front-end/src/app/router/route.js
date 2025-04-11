import {createBrowserRouter} from "react-router-dom";
import {Dashboard, HomeLayout, Landing, Login} from "../pages/index.js";

const router = createBrowserRouter(
    [
        {
            path: '/',
            element: <HomeLayout/>,
            children: [
                {
                    index: true,
                    element: <Landing/>
                },
                {
                    path: 'login',
                    element: <Login/>
                },
                {
                    path: 'dashboard',
                    element: <Dashboard/>
                }
            ]
        }
    ]
)


export default router;