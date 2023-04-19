import React from "react";
import { Input, Space } from 'antd';

import '../css/search_bar.css';

const { Search } = Input;

class SearchBar extends React.Component {

  onSearch = (value) => {
    fetch("http://localhost:8080/search/"+value) .then(response	=>	response.json())
        .then(data	=>	{

        }).catch(function	(ex)	{
      console.log('parsing	failed',	ex)
    })
  };

  render() {
    return (
      <div className='search-bar'>
        <Space direction="vertical">
          <h1 className='search-bar-title'>事件搜索引擎</h1>
          <Search
            placeholder="请输入事件名"
            allowClear
            enterButton
            size="large"
            style={{width:'600px'}}
            onSearch={this.onSearch}
          />
        </Space>
      </div>
    );
  }

}

export default SearchBar;