/*
   Copyright 2012 Harri Smatt

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package com.app.nbm.view.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.app.nbm.R;
import com.app.nbm.view.activity.curl.CurlPage;
import com.app.nbm.view.activity.curl.CurlView;

/**
 * Simple Activity for curl testing.
 * 
 * @author harism
 */
public class CurlActivity extends Activity {

	private CurlView mCurlView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_curl_text_data);

		int index = 0;
		if (getLastNonConfigurationInstance() != null) {
			index = (Integer) getLastNonConfigurationInstance();
		}
		mCurlView = (CurlView) findViewById(R.id.curl);
		mCurlView.setPageProvider(new PageProvider());
		mCurlView.setSizeChangedObserver(new SizeChangedObserver());
		mCurlView.setCurrentIndex(index);
		mCurlView.setBackgroundColor(0xFFFFFFFF);
	//	mCurlView.setBackgroundColor(0xFF202830);

		// This is something somewhat experimental. Before uncommenting next
		// line, please see method comments in CurlView.
		// mCurlView.setEnableTouchPressure(true);
	}

	@Override
	public void onPause() {
		super.onPause();
		mCurlView.onPause();
	}

	@Override
	public void onResume() {
		super.onResume();
		mCurlView.onResume();
	}

	@Override
	public Object onRetainNonConfigurationInstance() {
		return mCurlView.getCurrentIndex();
	}

	/**
	 * Bitmap provider.
	 */
	private class PageProvider implements CurlView.PageProvider {

		// Bitmap resources.
		private int[] mBitmapIds = { R.drawable.obama, R.drawable.road_rage,
				R.drawable.taipei_101, R.drawable.world };

		@Override
		public int getPageCount() {
			return 5;
		}

		private Bitmap loadBitmap(int width, int height, int index) {
			Bitmap b = Bitmap.createBitmap(width, height,
					Bitmap.Config.ARGB_8888);
			b.eraseColor(0xFFFFFFFF);
			Canvas c = new Canvas(b);
			String text1 = "पहली कहानी ( लक्ष्य पर ध्यान केंद्रित करना )\n" + "एक बार स्वामी विवेकानंद जी अपने आश्रम में सो रहे थे। कि तभी एक व्यक्ति उनके पास आया जो कि बहुत दुखी था और आते ही स्वामी विवेकानंद जी के चरणों में गिर पड़ा और बोला महाराज मैं अपने जीवन में खूब मेहनत करता हूँ हर काम खूब मन लगाकर भी करता हूँ फिर भी आज तक मैं कभी सफल व्यक्ति नहीं बन पाया।\n" + "\n" + "उस व्यक्ति कि बाते सुनकर स्वामी विवेकानंद ने कहा ठीक है। आप मेरे इस पालतू कुत्ते को थोड़ी देर तक घुमाकर लाये तब तक आपके समस्या का समाधान ढूँढ़ता हूँ इतना कहने के बाद वह व्यक्ति कुत्ते को घुमाने के लिए चल गया। और फिर कुछ समय बीतने के बाद वह व्यक्ति वापस आया। तो स्वामी विवेकानंद जी ने उस व्यक्ति से पूछ की यह कुत्ता इतना हाँफ क्यों रहा है। जबकि तुम थोड़े से भी थके हुए नहीं लग रहे हो आखिर ऐसा क्या हुआ ?\n" + "\n" + "इस पर उस व्यक्ति ने कहा कि मैं तो सीधा अपने रास्ते पर चल रहा था जबकि यह कुत्ता इधर उधर रास्ते भर भागता रहा और कुछ भी देखता तो उधर ही दौड़ जाता था. जिसके कारण यह इतना थक गया है ।\n" + "\n" + "इसपर स्वामी विवेकानंद जी मुस्कुराते हुए कहा बस यही तुम्हारे प्रश्नों का जवाब है. तुम्हारी सफलता की मंजिल तो तुम्हारे सामने ही होती है. लेकिन तुम अपने मंजिल के बजाय इधर उधर भागते हो जिससे तुम अपने जीवन में कभी सफल नही हो पाए. यह बात सुनकर उस व्यक्ति को समझ में आ गया था। की यदि सफल होना है तो हमे अपने मंज़िल पर ध्यान देना चाहिए।";
			TextView tv = new TextView(getApplicationContext());
			tv.setText(text1);
			tv.setTextColor(0xa0000000);
			tv.setText(getSafeSubstring(text1, 1800));
			tv.setTextSize(12);
			tv.setPadding(2,2,2,2);
		//	tv.setLineSpacing(2, 2);
			tv.layout(0, 0, getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels);
			//Canvas c = new Canvas(tv);
			tv.draw(c);

//			int margin = 7;
//			int border = 3;
//			Rect r = new Rect(margin, margin, width - margin, height - margin);
//
//			int imageWidth = r.width() - (border * 2);
//			int imageHeight = imageWidth * d.getIntrinsicHeight()
//					/ d.getIntrinsicWidth();
//			if (imageHeight > r.height() - (border * 2)) {
//				imageHeight = r.height() - (border * 2);
//				imageWidth = imageHeight * d.getIntrinsicWidth()
//						/ d.getIntrinsicHeight();
//			}
//
//			r.left += ((r.width() - imageWidth) / 2) - border;
//			r.right = r.left + imageWidth + border + border;
//			r.top += ((r.height() - imageHeight) / 2) - border;
//			r.bottom = r.top + imageHeight + border + border;
//
//			Paint p = new Paint();
//			p.setColor(0xFFC0C0C0);
//			c.drawRect(r, p);
//			r.left += border;
//			r.right -= border;
//			r.top += border;
//			r.bottom -= border;
//
//			d.setBounds(r);
//			d.draw(c);

			return b;
		}

		@Override
		public void updatePage(CurlPage page, int width, int height, int index) {

			switch (index) {
			// First case is image on front side, solid colored back.
			case 0: {
				Bitmap front = loadBitmap(width, height, 0);
				page.setTexture(front, CurlPage.SIDE_FRONT);
				page.setColor(Color.rgb(180, 180, 180), CurlPage.SIDE_BACK);
				break;
			}
			// Second case is image on back side, solid colored front.
			case 1: {
				Bitmap front = loadBitmap(width, height, 0);
				page.setTexture(front, CurlPage.SIDE_FRONT);
				page.setColor(Color.rgb(180, 180, 180), CurlPage.SIDE_BACK);

//				Bitmap back = loadBitmap(width, height, 2);
//				page.setTexture(back, CurlPage.SIDE_BACK);
//				page.setColor(Color.rgb(127, 140, 180), CurlPage.SIDE_FRONT);
				break;
			}
			// Third case is images on both sides.
			case 2: {

				Bitmap front = loadBitmap(width, height, 0);
				page.setTexture(front, CurlPage.SIDE_FRONT);
				page.setColor(Color.rgb(180, 180, 180), CurlPage.SIDE_BACK);
//				Bitmap front = loadBitmap(width, height, 1);
//				Bitmap back = loadBitmap(width, height, 3);
//				page.setTexture(front, CurlPage.SIDE_FRONT);
//				page.setTexture(back, CurlPage.SIDE_BACK);
				break;
			}
			// Fourth case is images on both sides - plus they are blend against
			// separate colors.
			case 3: {

				Bitmap front = loadBitmap(width, height, 0);
				page.setTexture(front, CurlPage.SIDE_FRONT);
				page.setColor(Color.rgb(180, 180, 180), CurlPage.SIDE_BACK);

//				Bitmap front = loadBitmap(width, height, 2);
//				Bitmap back = loadBitmap(width, height, 1);
//				page.setTexture(front, CurlPage.SIDE_FRONT);
//				page.setTexture(back, CurlPage.SIDE_BACK);
//				page.setColor(Color.argb(127, 170, 130, 255),
//						CurlPage.SIDE_FRONT);
//				page.setColor(Color.rgb(255, 190, 150), CurlPage.SIDE_BACK);
				break;
			}
			// Fifth case is same image is assigned to front and back. In this
			// scenario only one texture is used and shared for both sides.
			case 4:
				Bitmap front = loadBitmap(width, height, 0);
				page.setTexture(front, CurlPage.SIDE_FRONT);
				page.setColor(Color.rgb(180, 180, 180), CurlPage.SIDE_BACK);

//				Bitmap front = loadBitmap(width, height, 0);
//				page.setTexture(front, CurlPage.SIDE_BOTH);
//				page.setColor(Color.argb(127, 255, 255, 255),
//						CurlPage.SIDE_BACK);
				break;
			}
		}

	}

	/**
	 * CurlView size changed observer.
	 */
	private class SizeChangedObserver implements CurlView.SizeChangedObserver {
		@Override
		public void onSizeChanged(int w, int h) {
			if (w > h) {
				mCurlView.setViewMode(CurlView.SHOW_TWO_PAGES);
				mCurlView.setMargins(.1f, .05f, .1f, .05f);
			} else {
				mCurlView.setViewMode(CurlView.SHOW_ONE_PAGE);
				mCurlView.setMargins(.1f, .1f, .1f, .1f);
			}
		}
	}

	public String getSafeSubstring(String s, int maxLength){
		if(!TextUtils.isEmpty(s)){
			if(s.length() >= maxLength){
				return s.substring(0, maxLength);
			}
		}
		return s;
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		finish();
	}
}