package com.hwy.roundimage;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.hwy.round.BadgeImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listview;

    private List<String> mData;

    private Context mContext;

    private BadgeImageView mBadgeImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initBadge();

        listview = findViewById(R.id.listview);
        mContext = this;

        initData();

        listview.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return mData.size();
            }

            @Override
            public Object getItem(int position) {
                return mData.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                ViewHolder holder;

                if (convertView == null) {
                    holder = new ViewHolder();
                    convertView = View.inflate(mContext, R.layout.adapter_image, null);
                    holder.ivRound = convertView.findViewById(R.id.iv_round);
                    holder.ivSquare = convertView.findViewById(R.id.iv_square);
                    holder.ivNormal = convertView.findViewById(R.id.iv_normal);
                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder) convertView.getTag();
                }

                String path = mData.get(position);

                Glide.with(mContext).load(path).into(holder.ivRound);
                Glide.with(mContext).load(path).into(holder.ivSquare);
                Glide.with(mContext).load(path).into(holder.ivNormal);

                return convertView;
            }
        });

    }

    private void initBadge() {
        mBadgeImageView = findViewById(R.id.image_view);
        Glide.with(this)
                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1545068529971&di=b21181c5de4f8f7802099d82d25ae336&imgtype=0&src=http%3A%2F%2Fimg.juimg.com%2Ftuku%2Fyulantu%2F140625%2F330872-140625231F968.jpg")
                .into(mBadgeImageView);
    }

    private void initData() {
        mData = new ArrayList<>();
        mData.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527585331625&di=68d28d36e32ddecd4a1f9ead569be081&imgtype=0&src=http%3A%2F%2Fimg0.pconline.com.cn%2Fpconline%2F1306%2F09%2F3336552_143T2JU-0.jpg");
        mData.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527589642743&di=1b808d2957f0c53a7ccb2a55fc825f8f&imgtype=0&src=http%3A%2F%2Fimg0.pconline.com.cn%2Fpconline%2F1706%2F05%2F9332666_s_a318144f15444c7488d60c94584593a1_thumb.jpg");
        mData.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527589709207&di=2214c499dc8e9cc7b4462d2b903bf003&imgtype=0&src=http%3A%2F%2Fimg.cnmo-img.com.cn%2F1495_600x1000%2F1494544.jpg");
        mData.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527589770540&di=5a7eee312a26c45941507bc1909bb306&imgtype=0&src=http%3A%2F%2Fi1.sinaimg.cn%2FIT%2Fcr%2F2013%2F1206%2F1452128485.jpg");
        mData.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527589799222&di=a4e120473b8176377256ead844eaad8f&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F8%2F5129d6455aa09.jpg");
        mData.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528184554&di=11f2b707b77824e628711a82c21d7153&imgtype=jpg&er=1&src=http%3A%2F%2Fattachments.gfan.com%2Fforum%2Fattachments2%2Fday_110823%2F1108231803c7cfba4165f0ee79.jpg");
        mData.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527589859092&di=2474ec3298a892950777f4be3543b5b7&imgtype=0&src=http%3A%2F%2Fimage.game.uc.cn%2F2015%2F11%2F6%2F11302912.jpg");
        mData.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527589928441&di=c779fd04e61fbd9da8f0468db235c458&imgtype=0&src=http%3A%2F%2Fwww.th7.cn%2Fd%2Ffile%2Fp%2F2012%2F02%2F09%2F77b080fc506bbc76b935cd9f0a004c19.jpg");
        mData.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527589952657&di=4d5cba77457163f8c1eaf296fae92dfb&imgtype=jpg&src=http%3A%2F%2Fimg1.imgtn.bdimg.com%2Fit%2Fu%3D3549039866%2C2574816763%26fm%3D214%26gp%3D0.jpg");
        mData.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527589973833&di=2317addb4cc0d21d272992e912f22950&imgtype=0&src=http%3A%2F%2Fs2.cdn.deahu.com%2Fshow%2Flfile%2FA3FF3D08DC7279CA61851163A3869279.jpg");
        mData.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527590143636&di=36b79a6e1b45ee9925fff11fc0e2d6f3&imgtype=jpg&src=http%3A%2F%2Fimg4.imgtn.bdimg.com%2Fit%2Fu%3D1846522714%2C499929013%26fm%3D214%26gp%3D0.jpg");
        mData.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527590143636&di=36b79a6e1b45ee9925fff11fc0e2d6f3&imgtype=jpg&src=http%3A%2F%2Fimg4.imgtn.bdimg.com%2Fit%2Fu%3D1846522714%2C499929013%26fm%3D214%26gp%3D0.jpg");
        mData.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527590143636&di=36b79a6e1b45ee9925fff11fc0e2d6f3&imgtype=jpg&src=http%3A%2F%2Fimg4.imgtn.bdimg.com%2Fit%2Fu%3D1846522714%2C499929013%26fm%3D214%26gp%3D0.jpg");
        mData.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527590143636&di=36b79a6e1b45ee9925fff11fc0e2d6f3&imgtype=jpg&src=http%3A%2F%2Fimg4.imgtn.bdimg.com%2Fit%2Fu%3D1846522714%2C499929013%26fm%3D214%26gp%3D0.jpg");
        mData.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527590143636&di=36b79a6e1b45ee9925fff11fc0e2d6f3&imgtype=jpg&src=http%3A%2F%2Fimg4.imgtn.bdimg.com%2Fit%2Fu%3D1846522714%2C499929013%26fm%3D214%26gp%3D0.jpg");
        mData.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527590143636&di=36b79a6e1b45ee9925fff11fc0e2d6f3&imgtype=jpg&src=http%3A%2F%2Fimg4.imgtn.bdimg.com%2Fit%2Fu%3D1846522714%2C499929013%26fm%3D214%26gp%3D0.jpg");
        mData.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527590143636&di=36b79a6e1b45ee9925fff11fc0e2d6f3&imgtype=jpg&src=http%3A%2F%2Fimg4.imgtn.bdimg.com%2Fit%2Fu%3D1846522714%2C499929013%26fm%3D214%26gp%3D0.jpg");
        mData.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527590143636&di=36b79a6e1b45ee9925fff11fc0e2d6f3&imgtype=jpg&src=http%3A%2F%2Fimg4.imgtn.bdimg.com%2Fit%2Fu%3D1846522714%2C499929013%26fm%3D214%26gp%3D0.jpg");
        mData.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527590143636&di=36b79a6e1b45ee9925fff11fc0e2d6f3&imgtype=jpg&src=http%3A%2F%2Fimg4.imgtn.bdimg.com%2Fit%2Fu%3D1846522714%2C499929013%26fm%3D214%26gp%3D0.jpg");
        mData.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527590143636&di=36b79a6e1b45ee9925fff11fc0e2d6f3&imgtype=jpg&src=http%3A%2F%2Fimg4.imgtn.bdimg.com%2Fit%2Fu%3D1846522714%2C499929013%26fm%3D214%26gp%3D0.jpg");
        mData.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527590143636&di=36b79a6e1b45ee9925fff11fc0e2d6f3&imgtype=jpg&src=http%3A%2F%2Fimg4.imgtn.bdimg.com%2Fit%2Fu%3D1846522714%2C499929013%26fm%3D214%26gp%3D0.jpg");
    }

    static class ViewHolder {
        ImageView ivRound;
        ImageView ivSquare;
        ImageView ivNormal;
    }

}
