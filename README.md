# ShimmerEffect Library #

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
