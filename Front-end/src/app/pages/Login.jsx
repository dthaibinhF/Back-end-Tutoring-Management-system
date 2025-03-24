import React from 'react';
import {Col, Row} from 'antd';
import SignInCard from "../components/SignInCard.jsx";

import '../../assets/css/pages/Login.css'
import LoginContent from "../components/LoginContent.jsx";

const Login = () => {
    return (
        <div>
            <Row style={{ height: '100vh' }} justify="center" align='middle'>
                <Col span={6} className='content-container'>
                    <LoginContent/>
                </Col>
                <Col span={6} className='sign-in-card-container'>
                    <SignInCard/>
                </Col>
            </Row>
        </div>
    );
}

export default Login;