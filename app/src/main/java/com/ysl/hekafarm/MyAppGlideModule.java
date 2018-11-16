package com.ysl.hekafarm;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.module.AppGlideModule;

public class MyAppGlideModule extends AppGlideModule{
	public MyAppGlideModule() {
		super();
	}

	@Override
	public boolean isManifestParsingEnabled() {
		return super.isManifestParsingEnabled();
	}

	@Override
	public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
		super.applyOptions(context, builder);
	}

	@Override
	public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
		super.registerComponents(context, glide, registry);
	}
}
