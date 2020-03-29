package jpabook.jpashop.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@NoArgsConstructor
@Entity
public class CategoryItem {

    @ManyToOne
    @JoinColumn(name="CATEGORY_ID")
    private Category category;

    @ManyToOne
    @JoinColumn(name="ITEM_ID")
    private Item item;

    @Builder
    public CategoryItem(Category category, Item item) {
        this.category = category;
        this.item = item;
    }
}
