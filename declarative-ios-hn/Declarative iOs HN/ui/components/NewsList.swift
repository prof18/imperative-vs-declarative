//
//  NewsList.swift
//  Declarative iOs HN
//
//  Created by Marco Gomiero on 15/02/2020.
//  Copyright © 2020 Marco Gomiero. All rights reserved.
//

import SwiftUI

struct NewsList: View {
    
    var newsList: [News]
    
    init(newsList: [News]) {
        self.newsList = newsList
        UITableView.appearance().separatorStyle = .none
    }
    
    var body: some View {
        NavigationView {
            List {
                ForEach(self.newsList, id: \.self) { news in
                    NewsCard(news: news)
                }
            }
            .navigationBarTitle(Text("Declarative iOs HN"))
        }
    }
}

struct NewsList_Previews: PreviewProvider {
    static var previews: some View {
        NewsList(newsList: newsList)
    }
}
