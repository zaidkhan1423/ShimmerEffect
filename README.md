# ShimmerEffect Library #

### Example ###

<h1 align="center">
<video src="https://github.com/user-attachments/assets/745d6b42-62e1-444f-9d2d-b3acb0428640" alt="Shimmer" height="600"/><br />
compose-shimmer </h1>

A Jetpack compose modifier to add a shimmering effect to any Composable.
```gradle
    Box( modifier = Modifier.shimmerEffect() )
```

### Step 1. Add the JitPack repository to your build file ###
```gradle
dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
 ```

### Add it in your root build.gradle at the end of repositories: ###
```gradle
maven(url = "https://jitpack.io")
```

### Step 2. Add the dependency ###
```gradel
	dependencies {
	        implementation 'com.github.zaidkhan1423:ShimmerEffect:Tag'
	}
```
### Other ###
```gradle
    implementation("com.github.zaidkhan1423:ShimmerEffect:1.1")
```
