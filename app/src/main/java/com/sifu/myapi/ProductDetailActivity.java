package com.sifu.myapi;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class ProductDetailActivity extends AppCompatActivity {

    private ImageView productImage;
    private TextView productTitle;
    private TextView productPrice;
    private TextView productDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        productImage = findViewById(R.id.productImage);
        productTitle = findViewById(R.id.productTitle);
        productPrice = findViewById(R.id.productPrice);
        productDescription = findViewById(R.id.productDescription);

        // Get the passed product data
        Product product = (Product) getIntent().getSerializableExtra("product");

        // Populate the views with product data
        if (product != null) {
            productTitle.setText(product.getTitle());
            productPrice.setText("$" + product.getPrice());
            productDescription.setText(product.getDescription());
            Picasso.get().load(product.getImages().get(0)).into(productImage);
        }
    }
}
