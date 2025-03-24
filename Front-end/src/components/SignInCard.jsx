import {Button, Form, Input} from "antd";
import {useState} from "react";
import axios from "axios";
import {useNavigate} from "react-router-dom"; // Import useNavigate

const SignInCard = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(false);
    const navigate = useNavigate(); // Initialize useNavigate

    const onFinish = async (values) => {
        setLoading(true);
        setError(false);
        try {
            const response = await axios.post('http://localhost:8080/v1/api/login', {
                    username: email,
                    password: password
                }
            );
            console.log('Login successful: ', response);
            alert("Login successful");
            navigate("/dashboard");

        } catch (error) {
            console.log('Login failed: ', error);
            setError(true)
        } finally {
            setLoading(false);
        }

    };
    return (
        <>
            <div className='sign-in-card'>
                <h1>Sign in</h1>
                {error && <p style={{color: "red"}}>{error}</p>}
                <Form name='sign-in-form' layout='vertical' onFinish={(onFinish)}>
                    <Form.Item label='username' name='username' rules={[{required: true, message: 'Please input your username!'}]}>
                        <Input placeholder='enter email' onChange={(e) => setEmail(e.target.value)}/>
                    </Form.Item>
                    <Form.Item label='password' name='password' rules={[{required: true, message: 'Please input your password!'}]}>
                        <Input.Password placeholder='enter password' onChange={(e) => setPassword(e.target.value)}/>
                    </Form.Item>
                    <Form.Item>
                        <Button type="primary" htmlType="submit">
                            Submit
                        </Button>
                    </Form.Item>
                </Form>
            </div>
        </>
    )
}

export default SignInCard;