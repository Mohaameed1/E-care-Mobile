<?php

namespace App\Controller;

use App\Entity\AvisClient;
use App\Entity\Pharmacie;
use App\Repository\PharmacieRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\Serializer\Encoder\JsonEncoder;
use Symfony\Component\Serializer\Normalizer\NormalizerInterface;
use Symfony\Component\Serializer\Normalizer\ObjectNormalizer;
use Symfony\Component\Serializer\Serializer;
use Symfony\Component\Serializer\SerializerInterface;

class ApiPharmacieController extends AbstractController
{
    /**
     * @Route("/api/pharmacie", name="api_pharmacie")
     */
    public function index(): Response
    {
        return $this->render('api_pharmacie/index.html.twig', [
            'controller_name' => 'ApiPharmacieController',
        ]);
    }

    /**
     * @param PharmacieRepository $repository
     * @Route ("/AfficheAllpharmacie", name ="AfficheAllpharmacie")
     */
    public function AffichePharmacie(PharmacieRepository $repository, NormalizerInterface $normalizer)
    {

        $repo=$this->getDoctrine()->getRepository(Pharmacie::class);
        $pahramacie=$repository->findAll();

        $jsonContent=$normalizer->normalize($pahramacie,'json',['groups'=>'pharmacie']);

        return new Response(json_encode($jsonContent));
//        $serializer = new Serializer([new ObjectNormalizer()]);
//        $formatted = $serializer->normalize($pahramacie);

       // return new JsonResponse($formatted);



    }

    /**
     * @Route ("/newPharmacies", name ="newPharmacies")
     */
    public function newPharmacie(Request $request)
    {

        $em = $this->getDoctrine()->getManager();
        $pharmacie = new Pharmacie();
        $pharmacie->setNom($request->get('nom'));
        $pharmacie->setAdresse($request->get('adresse'));
        $pharmacie->setTelephone((int)$request->get('telephone'));
        $em->persist($pharmacie);
        $em->flush();

        $serializer = new Serializer( [new ObjectNormalizer()]);
        $formated = $serializer->normalize($pharmacie);
        return new JsonResponse($formated);
    }

    /**
     * @Route ("/deletePharmacies/{id}", name ="deletePharmacie")
     */
    public function deletePharmacieAction(Request $request,$id)
    {

        $em=$this->getDoctrine()->getManager();
        $pharmacie = $this->getDoctrine()->getManager()->getRepository(Pharmacie::class)->find($id);
        $em->remove($pharmacie);
        $em->flush();
        $serializer = new Serializer( [new ObjectNormalizer()]);
        $formated = $serializer->normalize("ok");
        return new JsonResponse($formated);
    }



    /**
     * @Route ("/updatePharmacie", name ="updatePharmacie")
     */
    public function updatePharmacieAction(Request $request)
    {

        $em=$this->getDoctrine()->getManager();
        $pharmacie = $this->getDoctrine()->getManager()->getRepository(Pharmacie::class)->find($request->get('id'));
        $pharmacie->setNom($request->get('nom'));
        $pharmacie->setAdresse($request->get('adresse'));
        $pharmacie->setTelephone((int)$request->get('telephone'));
        $em->persist($pharmacie);
        $em->flush();

        $serializer = new Serializer( [new ObjectNormalizer()]);
        $formated = $serializer->normalize("ok");
        return new JsonResponse($formated);
    }

    /**
     * @Route ("/giveAvis/{idp}", name ="giveAvis")
     */
    public function rateAction(\Symfony\Component\HttpFoundation\Request $request,$idp){


        $em = $this->getDoctrine()->getManager();
        $Avis = new AvisClient();
        $pharmacie = $this->getDoctrine()->getManager()->getRepository(Pharmacie::class)->find($idp);
        $rate =$request->get('rate');
        $Avis->setDescR($request->get('description'));
        $Avis->setRating($rate);
        $Avis->setIdRclient($pharmacie);
        $em->persist($Avis);
        $em->flush();
        return new Response("Done");
    }


}
