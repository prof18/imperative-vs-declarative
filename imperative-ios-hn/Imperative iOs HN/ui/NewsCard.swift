//
//  NewsCard.swift
//  Imperative iOs HN
//
//  Created by Marco Gomiero on 14/02/2020.
//  Copyright © 2020 Marco Gomiero. All rights reserved.
//

import Foundation
import UIKit

class NewsCard: UITableViewCell {
    
    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var dateLabel: UILabel!
    @IBOutlet weak var card: UIView!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        
        self.card.layer.cornerRadius = 16
        self.card.translatesAutoresizingMaskIntoConstraints = false
        self.card.backgroundColor = UIColor.white
        
        // add shadow on cell
        backgroundColor = .clear
        self.card.layer.masksToBounds = false
        self.card.layer.shadowOpacity = 0.23
        self.card.layer.shadowRadius = 4
        self.card.layer.shadowOffset = CGSize(width: 0, height: 0)
        self.card.layer.shadowColor = UIColor.black.cgColor
    }
    
    func setup(title: String, date: String) {
        self.titleLabel.text = title
        self.dateLabel.text = date
    }
}
