package com.hurteng.sandstorm.object;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.hurteng.sandstorm.myplane.R;

import java.util.Random;

/**
 * BOSS子弹4
 */
public class BossBullet4 extends EnemyBullet {

	private Bitmap bullet;

	public BossBullet4(Resources resources) {
		super(resources);
	}

	// 初始化数据
	@Override
	public void initial(int arg0, float arg1, float arg2) {
		isAlive = true;
		Random random = new Random();
		speed = random.nextInt(5) + 5;
		object_x = arg1 - object_width / 2;
		object_y = arg1 + 2*object_height;
		
	}

	// 初始化图片的资源
	@Override
	public void initBitmap() {
		// TODO Auto-generated method stub
		bullet = BitmapFactory.decodeResource(resources, R.drawable.bossbullet4);
		object_width = bullet.getWidth();
		object_height = bullet.getHeight();
	}

	// 对象的绘图方法
	@Override
	public void drawSelf(Canvas canvas) {
		// TODO Auto-generated method stub
		if (isAlive) {
			canvas.save();
			canvas.clipRect(object_x, object_y, object_x + object_width,
					object_y + object_height);
			canvas.drawBitmap(bullet, object_x, object_y, paint);
			canvas.restore();
			logic();
		}
	}

	// 释放资源的方法
	@Override
	public void release() {
		// TODO Auto-generated method stub
		if (!bullet.isRecycled()) {
			bullet.recycle();
		}
	}

	// 对象的逻辑函数
	@Override
	public void logic() {
		if (object_y >= 0) {
			object_y -= speed;
			object_x += Math.tan(System.currentTimeMillis()/1000);
			
		} else {
			isAlive = false;
		}
	}

	@Override
	public boolean isCollide(GameObject obj) {
		// TODO Auto-generated method stub
		return super.isCollide(obj);
	}

}
