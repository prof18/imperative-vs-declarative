import React from 'react';
import {
    ActivityIndicator,
    StyleSheet,
    View,
} from 'react-native'

export default class LoadingView extends React.Component {
    render() {
        return (
            <View style={styles.container}>
                <ActivityIndicator size="large" />
            </View>
        );
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center'
    }
});
