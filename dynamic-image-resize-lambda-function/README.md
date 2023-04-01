

# Image Resizer Lambda@Edge

## Description

This solution resizes your images on the fly. The user is able to resize images by Lambda function which is deployed in CloudFront distributions.

## Lambda build

```
npm i
rm -rf node_modules/sharp
SHARP_IGNORE_GLOBAL_LIBVIPS=1 npm install --arch=x64 --platform=linux --libc=glibc sharp
```

## Zip

```
zip -r function.zip .
```