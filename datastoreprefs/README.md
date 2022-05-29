# Prefs With DataStore

## Dependencies

#### 1- add these dependencies to your :app module

```groovy
def kotlin_version = "1.5.2" // latest kotlin version
def datastore_version = "1.0.0-alpha04" // use this version
def lifecycle_version = "2.4.1" // latest lifecycle version

// Preferences DataStore
implementation "androidx.datastore:datastore-preferences:$datastore_version"

// Coroutines
implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlin_version"
implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:$kotlin_version"

// Coroutine Lifecycle Scopes
implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
implementation "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version"

```

## Getting start

#### 1- create PrefsKeys.kt

* add your keys in the top level of kotlin file

```kotlin
import androidx.datastore.preferences.core.preferencesKey

const val KEY1 = preferencesKey<String>("key1")
const val KEY2 = preferencesKey<Int>("key2")
```

#### 2- in your project you can use these functions to interact with your Datastore preferences

```kotlin
// Save Single Prefs
suspend fun <T> Context.savePrefs(prefsKey: Preferences.Key<T>, value: T)

// Save Bulk Prefs
 suspend fun <T> Context.saveBulkPrefs(vararg keyValuePairs: Pair<Preferences.Key<T>, T>)
 
 // Read Prefs
 suspend fun <T> Context.readPrefs(prefsKey: Preferences.Key<T>): T?
```


