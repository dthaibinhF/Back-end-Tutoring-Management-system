import {createBrowserRouter, RouterProvider} from "react-router-dom";
import {Login, HomeLayout, Landing, Dashboard} from "./pages/index.js";

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

function App() {
    return (
        <RouterProvider router={router}/>
    )
}

export default App
