# Android-Zoom-Meeting-Join

# Launch Zoom App from your App

MJ Developer is inviting you to a scheduled Zoom meeting.

Topic: User's Personal Meeting Room

Join Zoom Meeting
Test https://us05web.zoom.us/j/2050427098761?pwd=MzlFa0dB4547TnVNRnhRa1J2bWhuZ3F6Zz09

Test Meeting ID: 205 049 7095
Test Passcode: S2bx4m

**Android**
For Android apps, you can either use the Package ID or the URL to enable the launch feature.

**Method 1: Use Package ID**
Use Android’s built-in  to launch the Zoom App using this package id:us.zoom.videomeetings.
This action includes a step that searches the app that matches the package ID in the system, so you might notice latency of about one second while executing.

```
private void launchZoomClient() {
    PackageManager pm = getPackageManager();
    Intent intent = pm.getLaunchIntentForPackage("us.zoom.videomeetings");
    if (intent != null) {
        startActivity(intent);
    }
}

```

**Method 2: Use URL**
Using the URL is faster as the URL scheme of our Zoom SDK has been registered in the system which enables deep links. Simply, parse the URL zoomus:// and launch it.

```
private void launchZoomUrl() {
    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("zoomus://"));
    if (intent.resolveActivity(getPackageManager()) != null) {
        startActivity(intent);
    }
}
```

![ZoomCapture](https://user-images.githubusercontent.com/3745464/100646169-af414000-3363-11eb-8938-e596423aa91e.PNG)

![kzoomunnamed](https://user-images.githubusercontent.com/3745464/100646183-b49e8a80-3363-11eb-82af-57870da4e76d.png)

![mzoomunnam,med](https://user-images.githubusercontent.com/3745464/100646186-b5cfb780-3363-11eb-9326-0cfb34aa61e7.png)
