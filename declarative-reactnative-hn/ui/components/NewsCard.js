import React from 'react';
import {
    StyleSheet,
    View,
    Text,
    TouchableOpacity,
    Linking
} from 'react-native'

export default class NewsCard extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        const { news } = this.props;
        if (news) {
            return (
                <View style={styles.container}>
                    <TouchableOpacity
                        onPress={() => {
                            if (news.url) {
                                Linking.openURL(news.url)
                            }
                        }}
                    >
                        <Text style={{ fontSize: 18 }}>{news.title}</Text>
                        <Text style={{ fontSize: 14, fontStyle: 'italic', marginTop: 9 }}>{news.time}</Text>
                    </TouchableOpacity>
                </View>
            );
        }
        return null;
    }
}

const styles = StyleSheet.create({
    container: {
        backgroundColor: '#ffffff',
        elevation: 4,
        borderRadius: 16,
        padding: 10,
        margin: 10
    },
});