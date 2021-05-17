<?php
namespace App\Controller;

use App\Entity\Clinique;
use App\Entity\Feedback;
use App\Entity\Reclamation;
use App\Form\ReclamationType;
use App\Repository\CliniqueRepository;
use App\Repository\ReclamationRepository;
use App\Repository\StadeRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\Serializer\Encoder\JsonEncoder;
use Symfony\Component\Serializer\Normalizer\ObjectNormalizer;
use Symfony\Component\Serializer\Serializer;
use Symfony\Component\Serializer\SerializerInterface;
use Symfony\Component\Serializer\Normalizer\NormalizerInterface;

class MMobileController extends AbstractController
{
    /**
     * @Route("/mmobile", name="mmobile")
     */
    public function index(): Response
    {
        return $this->render('mmobile/index.html.twig', [
            'controller_name' => 'MMobileController',
        ]);
    }

    /**
     * @Route("/listecliniqe", name="listecliniqe")

     */
    public function getCours():Response{
        $clinique= $this->getDoctrine()->getManager()->getRepository(Clinique::class)->findAll();
        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($clinique);
        return new JsonResponse($formatted);

    }
    /**
     * @Route("/addcl", name="add_clinique")
     */
    public function addClinique(Request $request){
        $clinique= new Clinique();
        $nomcl= $request->query->get("nomcl");
        $adressecl= $request->query->get("adressecl");
        $numerocl= $request->query->get("numerocl");

        $desccl= $request->query->get("desccl");



        $clinique->setNomcl($nomcl);
        $clinique->setAdressecl($adressecl);

        $clinique->setNumerocl($numerocl);
        $clinique->setDesccl($desccl);
        $em=$this->getDoctrine()->getManager();
        $em->persist($clinique);
        $em->flush();
        $serialize = new Serializer([new ObjectNormalizer()]);
        $formatted = $serialize->normalize("clinique Ajoutée");
        return new JsonResponse($formatted);

    }
    /**
     * @Route("/deleteclinique", name="deleteclinique", methods={"GET","POST"})
     *
     */
    public function deleteclinique(Request $request){
        $id=$request->get('id');
        $entityManager = $this->getDoctrine()->getManager();
        $clinique=$entityManager->getRepository(Clinique::class)->find($id);
        if($clinique!=null){
            $entityManager->remove($clinique);
            $entityManager->flush();
            $serialize = new Serializer([new ObjectNormalizer()]);
            $formatted = $serialize->normalize("feedback deleted");
            return new JsonResponse($formatted);
        }

    }
    /**
     * @Route("/updateclinique", name="updateclinique", methods={"GET","POST"})
     *
     */
    public function updateClinique(Request $request){
        $em=$this->getDoctrine()->getManager();
        $clinique=$this->getDoctrine()->getManager()->getRepository(Clinique::class)->find($request->get("id"));
        $clinique->setNomcl($request->get("nomcl"));
        $clinique->setAdressecl($request->get("adressecl"));
        $clinique->setNumerocl($request->get("numerocl"));
        $clinique->setDesccl($request->get("desccl"));

        $em->persist($clinique);
        $em->flush();
        $serialize = new Serializer([new ObjectNormalizer()]);
        $formatted = $serialize->normalize("feedback updated");
        return new JsonResponse($formatted);
    }


    /**
     * @Route("/detailfeedback", name="detailfeedback" , methods={"GET","POST"})
     *
     */



    public function Stadedetail(Request $request,CliniqueRepository $cliniqueRepository,SerializerInterface $serializerinterface)
    { $id=$request->get('id');
        $repo = $cliniqueRepository->find($id);

        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($repo);
        return new JsonResponse($formatted);

    }
}