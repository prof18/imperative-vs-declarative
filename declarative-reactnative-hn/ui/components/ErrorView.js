import React from 'react';
import {
    StyleSheet,
    View,
    Text,
    Button,
} from 'react-native'

export default class ErrorView extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        const { reason } = this.props;
        if (reason) {
            return (
                <View style={styles.container}>
                    <Text style={{ textAlign: "center" }}>{reason}</Text>
                    <View style={{ margin: 20 }}>
                        <Button
                            title="Refresh"
                            onPress={this.handlePress}
                        />
                    </View>
                </View>
            );
        }
        return null;
    }

    handlePress = () => {
        let onPress = this.props.onPress
        if ("function" === typeof onPress) {
            onPress();
        }
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
    }
});