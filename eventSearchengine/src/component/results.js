import React from "react";
import '../css/search_result.css'
import { Tree, MenuTree, MiniMenu, Catalog, Mind } from 'tree-graph-react';
import 'tree-graph-react/dist/tree-graph-react.cjs.development.css';
import {Button, Input, Space} from "antd";
import bus from './search_bar'
const data = {
  '001': {
    _key: '001',
    name: '事件信息',
    father: '',
    sortList: ['002', '003', '004', '005'],
    contract: false,
    checked: true,
    hour: 0.1,
    limitDay: 1610726400000,
  },
  '002': {
    _key: '002',
    name: '详情',
    father: '001',
    sortList: ['006', '007', '011'],
    contract: false,
    checked: true,
    hour: 0.1,
    limitDay: 1610726400000,
  },
  '003': {
    _key: '003',
    name: '地点',
    father: '001',
    sortList: [],
    checked: false,
    hour: 0.1,
    limitDay: 1610726400000,
  },
  '004': {
    _key: '004',
    name: '人物',
    father: '001',
    sortList: [],
    checked: false,
    hour: 0.1,
    limitDay: 1610726400000,
  },
  '005': {
    _key: '005',
    name: '时间',
    father: '001',
    sortList: [],
    checked: false,
    hour: 0.1,
    limitDay: 1610726400000,
  },
  '006': {
    _key: '006',
    name: '起因',
    father: '002',
    contract: false,
    sortList: ['008', '009'],

    checked: false,

    hour: 0.1,
    limitDay: 1610726400000,
  },
  '007': {
    _key: '007',
    name: '经过',
    father: '002',
    sortList: ['010'],

    checked: false,

    hour: 0.1,
    limitDay: 1610726400000,
  },
  '008': {
    _key: '008',
    name: '起因……',
    father: '006',
    sortList: [],

    checked: false,

    hour: 0.1,
    limitDay: 1610726400000,
  },
  '009': {
    _key: '009',
    name: '起因……',
    father: '006',
    sortList: [],

    checked: false,

    hour: 0.1,
    limitDay: 1610726400000,
  },
  '010': {
    _key: '010',
    name: '经过……',
    father: '007',
    sortList: [],
    checked: false,
    hour: 0.1,
    limitDay: 1610726400000,
  },
  '011': {
    _key: '011',
    name: '结果',
    father: '002',
    sortList: [],
    checked: false,
    hour: 0.1,
    limitDay: 1610726400000,
  },
};

class TextRes extends React.Component {
constructor(props) {
  super(props);
  this.state={
    title:"",
    content:"",
    url:"",
    time:""
  }
}
  render() {

    return (
      <div className='result-tag'>
        <a href={this.props.url}>{this.props.title}</a>
        <p>{this.props.content}</p>
        <p >{this.props.time}</p>
      </div>
    );
  }
}


class MindMapRes extends React.Component {
  constructor() {
    super();
    this.state = {
      nodes: [],
    }
  }

  componentDidMount() {
    this.setState({nodes: data});

  }

  render() {
    return (
      <Mind nodes={this.state.nodes} startId="001" singleColumn={true} disabled={true} />
    );
  }

}


const Res=[["事件","内容","https://www.baidu.com","2022/7/12"]]
const { Search } = Input;
class SearchResults extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      mind_map: false,
      results: Res,
    }
  }



  handleChangeDisplayToMind = () => {
    this.setState({mind_map: true});
  }

  handleChangeDisplayToTime = () => {
    this.setState({mind_map: false});
  }
  onSearch = (value) => {
    fetch("http://localhost:8080/search/"+value) .then(response	=>	response.json())
        .then(data	=>	{

       this.setState(

           {results:data}
       )
        }).catch(function	(ex)	{
      console.log('parsing	failed',	ex)
    })
  };



  render() {
    let elements = [];
    if (this.state.mind_map) {
      elements.push(<MindMapRes />)
    }
    else {
      this.state.results.forEach((res) => {
        elements.push(
          <TextRes title={res[0]}
                   content={res[1]}
                   url={res[2]}
                   time={res[3]}
          />
        )
      })
    }

    return (

      <div>
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
        <h1 className='result-title'>查询结果</h1>
        <Button onClick={this.handleChangeDisplayToMind} style={{marginRight:'10px'}} >思维导图</Button>
        <Button onClick={this.handleChangeDisplayToTime} >时间线</Button>
           { this.state.results.map(function(res,x){
              return (
                  <TextRes title={res[0]}
                           content={res[1]}
                           url={res[2]}
                           time={res[3]}
                  />
              )
          },this)
        }
      </div>
    );
  }

}

export default SearchResults;