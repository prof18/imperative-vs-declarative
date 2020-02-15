//
//  News.swift
//  Declarative iOs HN
//
//  Created by Marco Gomiero on 14/02/2020.
//  Copyright © 2020 Marco Gomiero. All rights reserved.
//

import Foundation

struct News: Hashable {
    let by: String
    let id: Int
    let score: Int
    let text: String?
    let time: Int
    let title: String
    let type: String
    let url: String?
    
    init(by: String, id: Int, score: Int, text: String? = nil, time: Int, title: String, type: String, url: String? = nil) {
        self.by = by
        self.id = id
        self.score = score
        self.text = text
        self.time = time
        self.title = title
        self.type = type
        self.url = url
    }
    
    
    func getStringTime() -> String {
        let d = Date(timeIntervalSince1970: TimeInterval(time))
        let df = DateFormatter()
        df.dateFormat = "d MMM yyyy"
        return df.string(from: d)
    }
}

