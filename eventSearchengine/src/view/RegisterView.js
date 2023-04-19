import React from "react";
import { Button, Checkbox, Form, Input } from "antd";
import '../css/login.css'
import {Link} from "react-router-dom";
import { createBrowserHistory, createHashHistory } from 'history';
class RegisterView extends React.Component {
    constructor(props) {
        super(props);
    }



    onFinish = (values) => {
        let username=values.username;
        let password=values.password;
        fetch("http://localhost:8080/register/"+username+"/"+password , {
        })
            .then((response) => response.json())
            .then((data) => {
                if(data=="注册成功！"){
                    alert("注册成功！")
                    const history = createBrowserHistory();
                    history.push(
                        {
                            pathname:"/MainPage",
                        }  );
                    history.go();
                    return;
                }
                if(data=="用户名已存在！"){
                    alert("用户名已存在！")
                    return;
                }
            })
        console.log('Success:', values);
    };

    onFinishFailed = (errorInfo) => {
        console.log('Failed:', errorInfo);
    };

    render() {
        return (
            <div className='login-container'>
                <div className='login-content'>
                    <h1>注册</h1>
                    <Form
                        name="basic"
                        labelCol={{span: 6,}}
                        wrapperCol={{span: 16,}}
                        onFinish={this.onFinish}
                        onFinishFailed={this.onFinishFailed}
                        autoComplete="off"
                    >

                        <Form.Item
                            label="用户名"
                            name="username"
                            rules={[{required: true, message: 'Please input your username!',},]}
                        >
                            <Input   />
                        </Form.Item>

                        <Form.Item label="新密码" name="password"   rules={[{required: true, message: 'Please input your password!',},]}>
                            <Input palceholder="请输入密码"/>
                        </Form.Item>

                        <Form.Item label="确认密码" name="pw2" rules={[
                            ({getFieldValue})=>({
                                validator(rule,value){
                                    if(getFieldValue('password') === value){
                                        return Promise.resolve()
                                    }
                                    return Promise.reject("两次密码输入不一致");
                                }
                            }

                            )
                        ]}

                        >
                            <Input palceholder="请确认密码"/>
                        </Form.Item>



                        <Form.Item
                            wrapperCol={{offset: 8, span: 16,}}
                        >
                            <Button type="primary" htmlType="submit">
                                Register
                            </Button>


                        </Form.Item>
                    </Form>
                </div>
            </div>
        );
    }
}

export default RegisterView;