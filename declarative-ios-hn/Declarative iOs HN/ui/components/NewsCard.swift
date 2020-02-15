//
//  NewsCard.swift
//  Declarative iOs HN
//
//  Created by Marco Gomiero on 15/02/2020.
//  Copyright © 2020 Marco Gomiero. All rights reserved.
//

import SwiftUI

struct NewsCard: View {
    let news: News
    
    var body: some View {
        HStack() {
            VStack(alignment: .leading) {
                Text(self.news.title)
                    .font(.system(size: 18))
                Spacer()
                    .frame(height: 9)
                Text(self.news.getStringTime())
                    .font(.system(size: 14))
                    .italic()
            }
            .layoutPriority(100)
            Spacer()
        }
        .padding()
        .background(Color.white)
        .cornerRadius(15)
        .shadow(color: Color.black.opacity(0.2), radius: 7, x: 0, y: 2)
        .onTapGesture {
            if let newsUrl = self.news.url {
                if let url = URL(string: newsUrl), !url.absoluteString.isEmpty {
                    UIApplication.shared.open(url, options: [:], completionHandler: nil)
                }
            }
        }
    }
}


struct NewsCard_Previews: PreviewProvider {
    static var previews: some View {
        NewsCard(news: newsList[1])
    }
}
