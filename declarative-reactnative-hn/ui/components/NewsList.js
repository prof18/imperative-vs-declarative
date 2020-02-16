import React from 'react';
import { View, FlatList} from 'react-native'
import NewsCard from './NewsCard';

export default class NewsList extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        const { newsList } = this.props;
        if (newsList) {
            return (
                <View>
                    <FlatList
                        data={newsList}
                        renderItem={({ item }) => (
                            <NewsCard
                                news={item}
                            >
                            </NewsCard>
                        )}
                        keyExtractor={item => item.id}
                    />
                </View>
            );
        }
        return null;
    }
}