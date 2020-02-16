import React, { Component } from 'react';
import LoadingView from './ui/components/LoadingView';
import ErrorView from './ui/components/ErrorView';
import Failure from './data/model/Failure';
import Success from './data/model/Success';
import newsList from './data/MockNews.js'
import NewsList from './ui/components/NewsList';

export class Home extends Component {
    constructor(props) {
        super(props);
        this.state = {
            loadingState: false,
            failureState: undefined,
            succesState: undefined
        };
    }

    componentDidMount() {
        this.generateError()
    }

    render() {

        if (this.state.loadingState) {
            return (
                <LoadingView />
            );
        } else if (this.state.failureState) {
            return (
                <ErrorView
                    reason={this.state.failureState.reason}
                    onPress={() => {
                        this.loadData()
                    }}
                >
                </ErrorView>
            );
        } else if (this.state.succesState) {
            return (
                <NewsList
                    newsList={this.state.succesState.newsList}
                ></NewsList>
            );
        }
        return null
    }

    loadData() {
        this.setState({
            loadingState: true,
            failureState: undefined,
            succesState: undefined
        })
        this.sleep(2000).then(() => {
            this.setState({
                loadingState: false,
                failureState: undefined,
                succesState: new Success(newsList)
            })
        });
    }

    generateError() {
        this.setState({
            loadingState: true,
            failureState: undefined,
            succesState: undefined
        })
        this.sleep(2000).then(() => {
            this.setState({
                loadingState: false,
                failureState: new Failure("This is a generated error only to try an error state"),
                succesState: undefined
            })
        });
    }

    sleep(ms) {
        return new Promise(resolve => setTimeout(resolve, ms));
    }
}

export default Home
