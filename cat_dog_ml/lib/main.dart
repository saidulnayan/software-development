import 'dart:io';
import 'package:image_picker/image_picker.dart';
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:tflite/tflite.dart';
import '../constants.dart';

void main() => runApp(
      const MaterialApp(
        home: MachineLearningApp(),
      ),
    );

class MachineLearningApp extends StatefulWidget {
  const MachineLearningApp({Key? key}) : super(key: key);

  @override
  _MachineLearningAppState createState() => _MachineLearningAppState();
}

class _MachineLearningAppState extends State<MachineLearningApp> {
  final ImagePicker _picker = ImagePicker();
  File? _image;
  List? _result;

  @override
  void initState() {
    super.initState();
    loadModelData().then((output) {
//after loading models, rebuild the UI.
      setState(() {});
    });
  }

  loadModelData() async {
//tensorflow lite plugin loads models and labels.
    await Tflite.loadModel(
        model: 'assets/model_unquant.tflite', labels: 'assets/labels.txt');
  }

  @override
  Widget build(BuildContext context) {
    Size size = MediaQuery.of(context).size;
    return Scaffold(
      body: SingleChildScrollView(
        child: Column(
          children: [
            _image != null ? testImage(size, _image) : titleContent(size),
            SizedBox(
              height: 20,
            ),
            Row(mainAxisAlignment: MainAxisAlignment.center, children: [
              galleryOrCamera(Icons.camera, ImageSource.camera),
              galleryOrCamera(Icons.photo_album, ImageSource.gallery),
            ]),
            SizedBox(height: 50),
            _result != null
                ? Text(
                    'It\'s a ${_result![0]['label']}.',
                    style: GoogleFonts.openSansCondensed(
                      fontWeight: FontWeight.bold,
                      fontSize: 30,
                    ),
                  )
                : Text(
                    '1. Select or Capture the image. \n2. Tap the submit button.',
                    style: GoogleFonts.openSans(fontSize: 16),
                  ),
            Padding(
              padding: const EdgeInsets.only(top: 30.0),
              child: ElevatedButton(
                style: ElevatedButton.styleFrom(
                  padding: EdgeInsets.symmetric(horizontal: 60),
                  elevation: 4,
                  primary: Colors.grey[300],
                ),
                onPressed: detectDogOrCat,
                //             onPressed: detectDogOrCat,
                child: Text(
                  'Submit',
                  style: GoogleFonts.roboto(
                    color: Colors.black,
                    fontWeight: bold,
                  ),
                ),
              ),
            )
            
          ],
        ),
      ),
    );
  }

  Container titleContent(Size size) {
    return Container(
//contains 55% of the screen height.
      height: size.height * 0.55,
      width: double.infinity,
      decoration: BoxDecoration(
        image: DecorationImage(
          image: AssetImage("assets/pets.jpg"),
          fit: BoxFit.cover,
//black overlay filter
          colorFilter: filter,
        ),
      ),
      child: Center(
        child: Column(
          children: [
            SizedBox(
              height: 60,
            ),
            Text(
              'Dogs Vs Cats',
              style: GoogleFonts.roboto(
                fontSize: 40,
                color: Colors.white,
                fontWeight: bold,
              ),
            ),
            Text(
              'Flutter Machine Learning App',
              style: GoogleFonts.openSansCondensed(
                fontWeight: bold,
                fontSize: 20,
                color: Colors.white,
              ),
            ),
          ],
        ),
      ),
    );
  }

  MaterialButton galleryOrCamera(IconData icon, ImageSource imageSource) {
    return MaterialButton(
      padding: EdgeInsets.all(14.0),
      elevation: 5,
      color: Colors.grey[300],
      onPressed: () {
        _getImage(imageSource);
      },
      child: Icon(
        icon,
        size: 20,
        color: Colors.grey[800],
      ),
      shape: CircleBorder(),
    );
  }

  _getImage(ImageSource imageSource) async {
//accessing image from Gallery or Camera.
    final XFile? _image = await _picker.pickImage(source: imageSource);
//image is null, then return
    if (_image == null) return;
    setState(() {
      this._image = File(_image.path);
      _result = null;
    }); 
  }

  Widget testImage(size, image) {
    return Container(
      height: size.height * 0.55,
      width: double.infinity,
      decoration: BoxDecoration(
        image: DecorationImage(
          image: FileImage(
            image!,
          ),
          fit: BoxFit.cover,
        ),
      ),
    );
  }

  void detectDogOrCat() async {
    if (_image != null) {
      try {
        _result = await Tflite.runModelOnImage(
          path: _image!.path,
          numResults: 2,
          threshold: 0.6,
          imageMean: 127.5,
          imageStd: 127.5,
        );
      } catch (e) {}
      setState(() {});
    }
  }
}